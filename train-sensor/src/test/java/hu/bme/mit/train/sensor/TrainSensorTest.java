package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Mock
    TrainUser user;
    TrainController controller;
    TrainSensor sensor;

    @Before
    public void before() {
        user = mock(TrainUser.class);
        controller = mock(TrainController.class);
        sensor = new TrainSensorImpl(controller,user);
    }

    @Test
    public void AlarmToTrue500() {
        sensor.overrideSpeedLimit(501);
        verify(user, times(1)).setAlarmState(true);
    }
    @Test
    public void AlarmToFalse() {
        sensor.overrideSpeedLimit(250);
        verify(user, times(1)).setAlarmState(false);
    }
    @Test
    public void AlarmToTrueNegativ() {
        sensor.overrideSpeedLimit(-10);
        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void Rule50Test()  {
        when(controller.getReferenceSpeed()).thenReturn(42);
        sensor.overrideSpeedLimit(20);
        verify(user, times(1)).setAlarmState(true);
    }
}