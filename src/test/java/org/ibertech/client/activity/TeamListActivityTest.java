package org.ibertech.client.activity;

/**
 * Created with IntelliJ IDEA.
 * User: rroldan
 * Date: 22/06/13
 * Time: 06:12
 * To change this template use File | Settings | File Templates.
 */

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Matchers.any;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import org.ibertech.client.IClientFactory;
import org.ibertech.client.ITeamServiceAsync;
import org.ibertech.client.place.TeamPlace;
import org.ibertech.client.ui.ITeamListView;
import org.ibertech.shared.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TeamListActivityTest {

    @Mock
    private IClientFactory clientFactoryMock;

    @Mock
    private PlaceController placeControllerMock;

    @Mock
    private ITeamListView teamListViewMock;

    @Mock
    private AcceptsOneWidget acceptsOneWidgetMock;

    @Mock
    private ITeamServiceAsync teamServiceAsyncMock;

    @Mock
    private EventBus eventBusMock;

    private List<Team> teams;
    private Team team1;
    private Team team2;

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() throws Exception {
        when(clientFactoryMock.getPlaceController()).thenReturn(placeControllerMock);
        when(clientFactoryMock.getTeamListView()).thenReturn(teamListViewMock);
        when(clientFactoryMock.getTeamService()).thenReturn(teamServiceAsyncMock);

        Answer<Void> answer = new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                AsyncCallback<List<Team>> asyncCallback = (AsyncCallback<List<Team>>) args[0];
                team1 = new Team();
                team1.setTeamName("TeamName");
                team1.setCoach("Coach");
                team1.setRace("Altos Elfos");
                team1.setNumFebb("1234");
                team1.setClub("Club");

                team2 = new Team();
                team1.setTeamName("TeamName2");
                team1.setCoach("Coach2");
                team1.setRace("Altos Elfos");
                team1.setNumFebb("1234");
                team1.setClub("Club");
                final List<Team> teamList = new ArrayList<Team>();
                teamList.add(team1);
                teamList.add(team2);
                asyncCallback.onSuccess(teams);
                return null;
            }
        };

        doAnswer(answer).when(teamServiceAsyncMock).getAllTeam(any(AsyncCallback.class));

        // set the real contacts object, when clientFactory.setContacts is
        // called
        Answer<Void> setTeamsAnswer = new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                teams = (List<Team>) invocation.getArguments()[0];

                return null;
            }
        };

        doAnswer(setTeamsAnswer).when(clientFactoryMock).setTeams(any(List.class));

        // Return the real contacts object, when clientFactory.getContacts is
        // called
        Answer<List<Team>> getContactsAnswer = new Answer<List<Team>>() {
            @Override
            public List<Team> answer(InvocationOnMock invocation) throws Throwable {
                return teams;
            }
        };

        doAnswer(getContactsAnswer).when(clientFactoryMock).getTeams();
    }

    @Test
    public void testGotoPlace() {
        TeamListActivity teamListActivity = new TeamListActivity(new TeamPlace(""), clientFactoryMock);

        TeamPlace teamPlace = new TeamPlace("");
        teamListActivity.goTo(teamPlace);

        verify(placeControllerMock).goTo(teamPlace);
    }
}
