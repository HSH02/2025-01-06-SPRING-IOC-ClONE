package util;

import com.framework.ioc.util.ClsUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.sample.TestCar;

import java.lang.reflect.Parameter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClsUtilTest {

    @Test
    @DisplayName("ClsUtil.loadClass with classPath")
    void t1() {
        Class<TestCar> cls = ClsUtil.loadClass("util.sample.TestCar");
        assertThat(cls).isEqualTo(TestCar.class);
    }

    @Test
    @DisplayName("ClsUtil.construct with cls")
    void t2() {
        TestCar testCar = ClsUtil.construct(TestCar.class, new Object[]{"BMW", 1234});

        assertThat(testCar.getName()).isEqualTo("BMW");
        assertThat(testCar.getNumber()).isEqualTo(1234);
    }

    @Test
    @DisplayName("ClsUtil.getParameters with clsPath")
    void t3() {
        Parameter[] parameters = ClsUtil.getParameters("util.sample.TestCar", new Object[]{"BMW", 1234});

        assertThat(parameters[0].getName()).isEqualTo("name");
        assertThat(parameters[0].getType()).isEqualTo(String.class);

        assertThat(parameters[1].getName()).isEqualTo("number");
        assertThat(parameters[1].getType()).isEqualTo(int.class);
    }

    @Test
    @DisplayName("ClsUtil.getParameters with cls")
    void t4() {
        Parameter[] parameters = ClsUtil.getParameters(TestCar.class, new Object[]{"BMW", 1234});

        assertThat(parameters[0].getName()).isEqualTo("name");
        assertThat(parameters[0].getType()).isEqualTo(String.class);

        assertThat(parameters[1].getName()).isEqualTo("number");
        assertThat(parameters[1].getType()).isEqualTo(int.class);
    }

    @Test
    @DisplayName("ClsUtil.getParameterNames with clsPath")
    void t6() {
        String[] parameterNames = ClsUtil.getParameterNames("util.sample.TestCar", new Object[]{"BMW", 1234});
        assertThat(parameterNames[0]).isEqualTo("name");
        assertThat(parameterNames[1]).isEqualTo("number");
    }

    @Test
    @DisplayName("ClsUtil.getParameterNames with cls")
    void t7() {
        String[] parameterNames = ClsUtil.getParameterNames(TestCar.class, new Object[]{"BMW", 1234});

        assertThat(parameterNames[0]).isEqualTo("name");
        assertThat(parameterNames[1]).isEqualTo("number");
    }
}