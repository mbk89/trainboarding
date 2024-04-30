package com.trainboarding;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.mockito.Mockito.mockStatic;

@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS)
class TrainBoardingApplicationTest {

    @Test
    void testMain() {

        try (MockedStatic<SpringApplication> mocked = mockStatic(SpringApplication.class)) {

            mocked.when(() -> SpringApplication.run(TrainBoardingApplication.class,
                            "foo", "bar"))
                    .thenReturn(Mockito.mock(ConfigurableApplicationContext.class));

            TrainBoardingApplication.main(new String[] { "foo", "bar" });

            mocked.verify(() -> SpringApplication.run(TrainBoardingApplication.class,
                    "foo", "bar"));
        }
    }
}