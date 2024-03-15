package edfacontroller;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class TwoWaySerialComm
{
	private static InputStream in;
	private static OutputStream out;

	void connect (int speed, String portName ) throws Exception
	{
		try {
			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			if ( portIdentifier.isCurrentlyOwned() )
			{
				System.out.println("Error: Port is currently in use");
			}
			else
			{
				CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
	
				if ( commPort instanceof SerialPort )
				{
					SerialPort serialPort = (SerialPort) commPort;
					serialPort.setSerialPortParams(speed,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
	
					in = serialPort.getInputStream();
					out = serialPort.getOutputStream();
	
				}
				else
				{
					System.out.println("Error: Only serial ports are handled by this example.");
				}
			}
		}catch(IOException e) {
			throw e;
		}
	}

	public static String readResponse(){
		byte[] b = new byte[1024];
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int len = -1;
		try{
			while ((len = TwoWaySerialComm.in.read(b)) != -1) {
				out.write(b, 0, len);
				if((new String(b, 0, len)).contains(">")) break;
			}
		}
		catch(IOException e) {}
			return out.toString();
		}

	public void sendCommand(String cmd) {
	    System.out.println("Sending :" + cmd);
		try
		{
			byte[] sbyte = cmd.getBytes();

			for(int i = 0; i < sbyte.length; i++)
			{
				out.write(sbyte[i]);
			}
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
	}
	
	public void sendCommand(byte b){
        try{
                        out.write(b);

        }
        catch( IOException e){
                e.printStackTrace();
        }
}

	public String sendPump(String cmd){
		sendCommand("pump " + cmd +"\n");
		String res = readResponse();
		System.out.println(res);
		return res;
	}

	public void sendVer() throws IOException {
		sendCommand("ver\n");
		String res = readResponse();
		System.out.println(res);
	}

	public String sendSpin() throws IOException {
		sendCommand("spin\n");

		String res = readResponse();

		System.out.println(res);
		
		return res;
	}

	public String sendSpout() throws IOException{
		sendCommand("spout\n");

		String res = readResponse();

		System.out.println(res);
		
		return res;
	}

	public void gain(String port, double d){
		System.out.println("port " + port + " will gain " + d + " dBm");
		System.out.println("sending SMODE " + port + " g " + d);
		sendCommand("smode " + port + " g " + d + "\n");
		readResponse();
		try{
			sendSpout();
		}
		catch(IOException e){}
	}

	public void output(String port, double d){
		System.out.println("port " + port + "'s output will be " + d + " dBm");
		System.out.println("sending SMODE " + port + " p " + d);
		sendCommand("smode " + port + " p " + d + "\n");
		readResponse();
		try{
			sendSpout();
		}
		catch(IOException e){}
	}

	public void current(String port, double d){
		try{
			sendSpout();
		}
		catch(IOException e){}
	}

	public static class SerialReader implements Runnable// for  debug
	{
		private static InputStream in;

		public SerialReader ( InputStream in)
		{
			SerialReader.in = in;
		}

		public void run ()
		{
			byte[] buffer = new byte[1024];
			int len = -1;
			try
			{
				while ( ( len = SerialReader.in.read(buffer)) > -1 )
				{
					System.out.print(new String(buffer,0,len));
				}
			}
			catch ( IOException e )
			{
				e.printStackTrace();
			}
		}
	}

	public static class SerialWriter implements Runnable// for  debug
	{
		OutputStream out;

		public SerialWriter ( OutputStream out )
		{
			this.out = out;
		}

		public void run ()
		{
			try
			{
				int c = 0;
				while ( ( c = System.in.read()) > -1 )
				{
					this.out.write(c);
				}
			}
			catch ( IOException e )
			{
				e.printStackTrace();
			}
		}
	}

}