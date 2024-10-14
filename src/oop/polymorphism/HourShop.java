package oop.polymorphism;

public class HourShop{
    static void callPrint(Clock c){
        c.printTime();
    }

    public static void main(String[] args) {
        HourClock hours = new HourClock();
        hours.seconds = 7700;
        hours.printTime();
        Timer timer = new Timer();
        timer.second = 550;
        timer.printTime();

        Clock[] clocks = {timer, hours};
    }


}
class HourClock implements Clock{

    int seconds;

    @Override
    public void printTime() {
        //HH:mm:ss
        int hours = seconds / 3600;
        int mins = (seconds % 3600) / 60;
        int secs = seconds % 60;
        System.out.println(hours + ":" + mins + ":" + secs);
    }

    @Override
    public int getTime() {
        return seconds;
    }
}
class Timer implements Clock{
    int second;

    @Override
    public void printTime() {
        System.out.println((second/60) + ":" + (second%60));
    }

    @Override
    public int getTime() {
        return second;
    }
}