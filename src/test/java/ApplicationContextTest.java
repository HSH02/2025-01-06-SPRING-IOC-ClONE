import com.ApplicationContext;
import com.testPost.repository.TestPostRepository;
import com.testPost.service.TestFacadePostService;
import com.testPost.service.TestPostService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApplicationContextTest {
    private static ApplicationContext applicationContext;

    @BeforeAll
    public static void beforeAll() {
        applicationContext = new ApplicationContext("com");
        applicationContext.init();
    }

    @Test
    @DisplayName("ApplicationContext 객체 생성")
    public void t1() {
        System.out.println(applicationContext);
    }

    @Test
    @DisplayName("testPostService 빈 얻기")
    public void t2() {
        TestPostService testPostService = applicationContext
                .genBean("testPostService");

        assertThat(testPostService).isNotNull();
    }

    @Test
    @DisplayName("testPostService 빈을 다시 얻기, 싱글톤이어야 함")
    public void t3() {
        TestPostService testPostService1 = applicationContext
                .genBean("testPostService");

        TestPostService testPostService2 = applicationContext
                .genBean("testPostService");

        assertThat(testPostService1).isSameAs(testPostService2);
    }

    @Test
    @DisplayName("testPostRepository")
    public void t4() {
        TestPostRepository testPostRepository = applicationContext
                .genBean("testPostRepository");

        assertThat(testPostRepository).isNotNull();
    }

    @Test
    @DisplayName("testPostService has testPostRepository")
    public void t5() {
        TestPostService testPostService = applicationContext
                .genBean("testPostService");

        assertThat(testPostService).hasFieldOrPropertyWithValue(
                "testPostRepository",
                applicationContext.genBean("testPostRepository")
        );
    }

    @Test
    @DisplayName("testFacadePostService has testPostService, testPostRepository")
    public void t6() {
        TestFacadePostService testFacadePostService = applicationContext
                .genBean("testFacadePostService");
        assertThat(testFacadePostService).hasFieldOrPropertyWithValue(
                "testPostService",
                applicationContext.genBean("testPostService")
        );
        assertThat(testFacadePostService).hasFieldOrPropertyWithValue(
                "testPostRepository",
                applicationContext.genBean("testPostRepository")
        );
    }

}