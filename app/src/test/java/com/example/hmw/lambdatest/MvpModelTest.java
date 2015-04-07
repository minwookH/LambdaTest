package com.example.hmw.lambdatest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(RobolectricTestRunner.class)
public class MvpModelTest {

    private MvpModel mvpModel;

    @Before
    public void setUp() throws Exception {
        mvpModel = MvpModel_.getInstance_(Robolectric.application);
    }

    @Test
    public void testNetworking() throws Exception {
        String networking = mvpModel.networking();

        assertThat(networking, is(notNullValue()));
    }
}