/**
 * @author Emirhan Uzun / 171044019
 * @since 02/25/2020
 *	This Cargo class extends by Company class.It includes cargo informations 
 */
public class Cargo extends Company{
	protected String senderName;
	protected String senderSurname;
	protected String receiverName;
	protected String receiverSurname;
	protected String trackingNumber;
	protected String currentStatus;


	/**
	 * @param sender_Name This is the sender name
	 * @param sender_Surname This is the sender surname
	 * @param receiver_Name This is the receiver name
	 * @param receiver_Surname This is the receiver surname
	 * @param tracking_Number This is the tracking number
	 */
	public Cargo(String sender_Name, String sender_Surname, String receiver_Name, String receiver_Surname,
			String tracking_Number) {
		this.senderName = sender_Name;
		this.senderSurname = sender_Surname;
		this.receiverName = receiver_Name;
		this.receiverSurname = receiver_Surname;
		this.trackingNumber = tracking_Number;
		this.currentStatus = "Not Delivered";
	}
	
	public String getSenderName() {
		return senderName;
	}

	public String getSenderSurname() {
		return senderSurname;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverSurname() {
		return receiverSurname;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}
	
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public String toString() {
		return "Cargo \n[Sender Name = " + senderName + "\nSender Surname = " + senderSurname + " \nReceiver Name = " + receiverName
				+ "\nReceiver Surname = " + receiverSurname + "\nTracking Number = " + trackingNumber + "\nCurrent Status = "
				+ currentStatus + "]";
	}
}
