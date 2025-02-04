package nl.pin.jukeboxInventory.exceptions;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
