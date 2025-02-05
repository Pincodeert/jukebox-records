package nl.pin.jukeboxInventory.dtos;

public class ArtistInputDto {

    private String firstName;

    private String lastName;


    private String bandName;

    private String records;

    private String tracks;



    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getRecords() {
        return records;
    }


    public void setRecords(String records) {
        this.records = records;
    }


    public String getTracks() {
        return tracks;
    }


    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

}
