package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class AlarmTest {
    @Test
    public void checkAlarmRingsWhenPressureIsTooLow() {
        Sensor mockSensor = mock(Sensor.class);
        when(mockSensor.popNextPressurePsiValue()).thenReturn(16.0);

        Alarm alarm = new Alarm(mockSensor);
        alarm.check(mockSensor);
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void checkAlarmRingsWhenPressureIsTooHigh() {
        Sensor mockSensor = mock(Sensor.class);
        when(mockSensor.popNextPressurePsiValue()).thenReturn(22.0);

        Alarm alarm = new Alarm(mockSensor);
        alarm.check(mockSensor);
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void checkAlarmDoesNotRingWhenPressureIsOk() {
        Sensor mockSensor = mock(Sensor.class);
        when(mockSensor.popNextPressurePsiValue()).thenReturn(18.0);

        Alarm alarm = new Alarm(mockSensor);
        alarm.check(mockSensor);
        assertFalse(alarm.isAlarmOn());
    }
}
