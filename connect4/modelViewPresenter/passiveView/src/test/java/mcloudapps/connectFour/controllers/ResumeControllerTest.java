package mcloudapps.connectFour.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mcloudapps.connectFour.views.ResumeView;
import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.models.GameBuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ResumeControllerTest extends ControllerTest {
    
    @Mock
    private ResumeView resumeView;
    
    @Override
    protected Controller getController(String... rows) {
        return new ResumeController(new GameBuilder().rows(rows).build(), this.viewFactory);
    }

    @Test
    public void testGivenResumeControllerWhenControlThenReturnFalse() {
        when(this.viewFactory.createResumeView()).thenReturn(this.resumeView);
        when(this.resumeView.read()).thenReturn(false);
        this.controller = new ResumeController(new Game(), this.viewFactory);
        assertThat(((ResumeController) this.controller).control(), is(false));
    }

    @Test
    public void testGivenResumeControllerWhenControlThenReturnTrue() {
        when(this.viewFactory.createResumeView()).thenReturn(this.resumeView);
        when(this.resumeView.read()).thenReturn(true);
        this.controller = new ResumeController(new Game(), this.viewFactory);
        assertThat(((ResumeController) this.controller).control(), is(true));
    }
}
