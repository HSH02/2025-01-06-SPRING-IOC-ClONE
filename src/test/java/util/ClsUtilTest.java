package util;

import com.framework.annotations.Component;
import com.framework.ioc.util.ClsUtil;
import com.standard.util.Ut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import util.sample.TestCar;
import util.sample.TestPerson;

import java.lang.reflect.Parameter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.reflections.scanners.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.reflections.scanners.Scanners.TypesAnnotated;

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
    @DisplayName("ClsUtil.getParameters with clsPath, parameters")
    void t4() {
        Parameter[] parameters = ClsUtil.getParameters(TestCar.class, new Object[]{"BMW", 1234});

        assertThat(parameters[0].getName()).isEqualTo("name");
        assertThat(parameters[0].getType()).isEqualTo(String.class);

        assertThat(parameters[1].getName()).isEqualTo("number");
        assertThat(parameters[1].getType()).isEqualTo(int.class);
    }

    @Test
    @DisplayName("ClsUtil.getParameters with clsPath, parameterTypes")
    void t5() {
        Parameter[] parameters = ClsUtil.getParameters("util.sample.TestCar", new Class[]{String.class, int.class});

        assertThat(parameters[0].getType()).isEqualTo(String.class);
        assertThat(parameters[0].getName()).isEqualTo("name");

        assertThat(parameters[1].getType()).isEqualTo(int.class);
        assertThat(parameters[1].getName()).isEqualTo("number");
    }

    @Test
    @DisplayName("ClsUtil.getParameters with cls, parameters")
    void t6() {
        String[] parameterNames = ClsUtil.getParameterNames("util.sample.TestCar", new Object[]{"BMW", 1234});
        assertThat(parameterNames[0]).isEqualTo("name");
        assertThat(parameterNames[1]).isEqualTo("number");
    }

    @Test
    @DisplayName("ClsUtil.getParameterNames with cls, parameterTypes")
    void t7() {
        Parameter[] parameters = ClsUtil.getParameters(TestCar.class, new Class[]{String.class, int.class});

        assertThat(parameters[0].getType()).isEqualTo(String.class);
        assertThat(parameters[0].getName()).isEqualTo("name");

        assertThat(parameters[1].getType()).isEqualTo(int.class);
        assertThat(parameters[1].getName()).isEqualTo("number");
    }

    @Test
    @DisplayName("ClsUtil.getParameterNames with clsPath, parameters")
    void t8() {
        String[] parameterNames = ClsUtil.getParameterNames("util.sample.TestCar", new Object[]{"BMW", 1234});

        assertThat(parameterNames[0]).isEqualTo("name");
        assertThat(parameterNames[1]).isEqualTo("number");
    }

    @Test
    @DisplayName("ClsUtil.getParameterNames with clsPath, parameterTypes")
    void t9() {
        String[] parameterNames = ClsUtil.getParameterNames("util.sample.TestCar", new Class[]{String.class, int.class});
        assertThat(parameterNames[0]).isEqualTo("name");
        assertThat(parameterNames[1]).isEqualTo("number");
    }

    @Test
    @DisplayName("ClsUtil.getParameterNames with cls, parameters")
    void t10() {
        String[] parameterNames = ClsUtil.getParameterNames(TestCar.class, new Object[]{"BMW", 1234});

        assertThat(parameterNames[0]).isEqualTo("name");
        assertThat(parameterNames[1]).isEqualTo("number");
    }

    @Test
    @DisplayName("ClsUtil.getParameterNames with cls, parameterTypes")
    void t11() {
        String[] parameterNames = ClsUtil.getParameterNames(TestCar.class, new Class[]{String.class, int.class});
        assertThat(parameterNames[0]).isEqualTo("name");
        assertThat(parameterNames[1]).isEqualTo("number");
    }

    @Test
    @DisplayName("ClsUtil.getParameterNames with no args")
    void t12() {
        String[] parameterNames = ClsUtil.getParameterNames(TestPerson.class);
        assertThat(parameterNames[0]).isEqualTo("name");
        assertThat(parameterNames[1]).isEqualTo("age");
    }

    @Test
    @DisplayName("reflections test")
    void t13() {
        Reflections reflections = new Reflections("com", Scanners.TypesAnnotated);

        Map<String, Class<?>> clsMap = reflections.getTypesAnnotatedWith(Component.class)
                .stream()
                .filter(cls -> !cls.isAnnotation())  // 어노테이션 자체는 제외
                .collect(LinkedHashMap::new,        // 새 LinkedhashMap 생성
                        (map, cls) -> map.put(Ut.str.lcfirst(cls.getSimpleName()), cls), // 키-값 쌍 추가
                        Map::putAll); // 맵 변환

        System.out.println(clsMap);
    }
}