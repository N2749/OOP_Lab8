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
            return (new Date().getTime() - start.getTime()) / (1000 * 60);
        return end.getTime() - start.getTime();
    }

    public double end(){
        end = new Date();
        return calculateDuration();
    }
}
