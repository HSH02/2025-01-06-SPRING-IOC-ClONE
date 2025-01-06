package util;

import com.framework.ioc.util.ClsUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.sample.TestCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClsUtilTest {

    @Test
    @DisplayName("ClsUtil.loadClass")
    void t1() {
        Class<TestCar> cls = ClsUtil.loadClass("util.sample.TestCar");
        assertThat(cls).isEqualTo(TestCar.class);
    }

    @Test
    @DisplayName("ClsUtil.construct")
    void t2() {
        TestCar testCar = ClsUtil.construct("util.sample.TestCar", new Object[]{"BMW", 1234});

        assertThat(testCar.getName()).isEqualTo("BMW");
        assertThat(testCar.getNumber()).isEqualTo("1234");
    }


}