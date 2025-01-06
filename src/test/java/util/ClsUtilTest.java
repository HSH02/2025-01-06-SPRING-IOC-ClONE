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


}