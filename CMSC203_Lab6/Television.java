/**
 * The purpose of this class is to model a television
 * Your name and today's date
 */
public class Television {
    private final String MANUFACTURER;
    private final int SCREEN_SIZE;
    
    private boolean powerOn;
    private int channel;
    private int volume;
    
    /**
     * Constructor to create a Television object with given manufacturer and screen size
     * @param brand The manufacturer brand of the TV
     * @param size The screen size of the TV in inches
     */
    public Television(String brand, int size) {
        MANUFACTURER = brand;
        SCREEN_SIZE = size;
        powerOn = false;
        volume = 20;
        channel = 2;
    }
    
    /**
     * Returns the current volume level
     * @return the current volume
     */
    public int getVolume() {
        return volume;
    }
    
    /**
     * Returns the current channel
     * @return the current channel
     */
    public int getChannel() {
        return channel;
    }
    
    /**
     * Returns the manufacturer brand
     * @return the manufacturer name
     */
    public String getManufacturer() {
        return MANUFACTURER;
    }
    
    /**
     * Returns the screen size
     * @return the screen size in inches
     */
    public int getScreenSize() {
        return SCREEN_SIZE;
    }
    
    /**
     * Sets the channel to the specified value
     * @param station the channel to set
     */
    public void setChannel(int station) {
        channel = station;
    }
    
    /**
     * Toggles the power state between on and off
     */
    public void power() {
        powerOn = !powerOn;
    }
    
    /**
     * Increases the volume by 1
     */
    public void increaseVolume() {
        volume++;
    }
    
    /**
     * Decreases the volume by 1
     */
    public void decreaseVolume() {
        volume--;
    }
}