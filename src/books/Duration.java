package books;

import java.util.Date;
//calculates duration in minutes
public class Duration {

    private Date start;
    private Date end;

    public Duration() {
        this.start = new Date();
    }

    public double calculateDuration() {
        if(end == null)
            return ((double) new Date().getTime() - start.getTime()) / 60000;
        return end.getTime() - start.getTime();
    }

    public double end(){
        if(end != null) {
            end = new Date();
        }
        return calculateDuration();
    }
}
