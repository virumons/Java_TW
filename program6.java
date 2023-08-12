package practices.oop;


import java.util.concurrent.LinkedBlockingQueue; 
import java.util.concurrent. ThreadLocalRandom;

public class program6 {
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		LinkedBlockingQueue<String> responseQueue=new LinkedBlockingQueue<>();
		LinkedBlockingQueue<String> requestQueue= new LinkedBlockingQueue<>();
		
		Thread serverThread = new Thread(() -> {
			try {

				String request = requestQueue.take();

				System.out.println("Server recieving the request :" + request); 

				Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000)); 
				responseQueue.put("Message recieved");

			} catch (InterruptedException e) { // TODO Auto-generated catch block

				e.printStackTrace();

			}


		});

		serverThread.start();

		Thread clientThread = new Thread(() -> {

			try {

				String request = "Request";

				System.out.println("client sending the request :"+ request);

				requestQueue.put(request);


				String response = responseQueue.take();

				System.out.println("client recieved response:" + response); }
			catch (InterruptedException e) {

				e.printStackTrace();

			}

		});

		clientThread.start();

		try {

			serverThread.join();

			clientThread.join();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}
	}}
