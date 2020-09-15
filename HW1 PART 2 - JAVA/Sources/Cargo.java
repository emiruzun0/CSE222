/**
 * @author Emirhan Uzun
 * @since 03/03/2020
 * This class extends from Company class.It includes cargo's sender's and receiver's information 
 *
 */
public class Cargo extends Company{
	protected String senderName;
	protected String senderSurname;
	protected String receiverName;
	protected String receiverSurname;
	protected String trackingNumber;
	protected String currentStatus;

	/**
	 * @param senderName Cargo's sender name 
	 * @param senderSurname Cargo's sender surname
	 * @param receiverName Cargo's receiver name
	 * @param receiverSurname Cargo's receiver surname
	 * @param trackingNumber Cargo's tracking number
	 * This constructor initialize the cargo information
	 */
	public Cargo(String senderName, String senderSurname, String receiverName, String receiverSurname,
			String trackingNumber) {
		super();
		this.senderName = senderName;
		this.senderSurname = senderSurname;
		this.receiverName = receiverName;
		this.receiverSurname = receiverSurname;
		this.trackingNumber = trackingNumber;
		this.currentStatus = "Not delivered";
	}
	
	/**
	 * @return the cargo's sender name
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * @param senderName It is the name which is changed with sender name
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * @return the cargo's sender surname
	 */
	public String getSenderSurname() {
		return senderSurname;
	}
	/**
	 * @param senderSurname  It is the surname which is changed with sender surname
	 */
	public void setSenderSurname(String senderSurname) {
		this.senderSurname = senderSurname;
	}
	/**
	 * @return the cargo's receiver name
	 */
	public String getReceiverName() {
		return receiverName;
	}
	/**
	 * @param receiverName It is the name which is changed with receiver name
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	/**
	 * @return the cargo's receiver surname
	 */
	public String getReceiverSurname() {
		return receiverSurname;
	}
	/**
	 * @param receiverSurname It is the surname which is changed with receiver surname
	 */
	public void setReceiverSurname(String receiverSurname) {
		this.receiverSurname = receiverSurname;
	}
	/**
	 * @return the cargo's tracking number
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}
	/**
	 * @param trackingNumber  It is the number which is changed with tracking number
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	/**
	 * @return the cargo's current status
	 */
	public String getCurrentStatus() {
		return currentStatus;
	}

	/**
	 * This method changes the current status of cargo
	 * @param currentStatus It is the status which is changed with current status
	 */
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
		System.out.println(this.getTrackingNumber() + "'s cargo status changed ! ");
		this.toString();
	}
	/**
	 * To string returns the cargo informations
	 */
	@Override
	public String toString() {
		return "Cargo(es) [senderName=" + senderName + ", senderSurname=" + senderSurname + ", receiverName=" + receiverName
				+ ", receiverSurname=" + receiverSurname + ", trackingNumber=" + trackingNumber + ", Status = " + currentStatus + "]\n";
	}
}
