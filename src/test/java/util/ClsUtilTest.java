package util;

import com.ApplicationContext;
import com.repository.TestPostRepository;
import com.service.TestFacadePostService;
import com.service.TestPostService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.sample.TestCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClsUtilTest {

    @Test
    @DisplayName("ClsUtil.loadClass")
    void t1() {
        Class<TestCar> cls = ClsUtil.loadClass("com.framework.ioc.util.sample.TestCar");

        assertThat(cls).isEqualTo(TestCar.class);
    }


}