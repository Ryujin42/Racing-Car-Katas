package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    protected Sensor sensor;

    protected boolean alarmState = true;

    public Alarm(Sensor sensor)
    {
        this.sensor = sensor;
    }

    public void check(Sensor sensor)
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        alarmState = psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue;
    }

    public boolean isAlarmOn()
    {
        return alarmState;
    }
}
