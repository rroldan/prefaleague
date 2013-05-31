package org.ibertech.client.ui;



import java.util.EnumMap;
import java.util.Map;



import com.github.gwtbootstrap.client.ui.Divider;
import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class TeamNavbarView extends Composite  implements ITeamNavbarView {
	
	private Presenter presenter;

	private static TeamNavbarViewUiBinder uiBinder = GWT
			.create(TeamNavbarViewUiBinder.class);
	@UiField
    Nav nav;
	
	@UiField
	NavLink nlgroups;
	
	@UiField
	NavLink nlplayers;

	interface TeamNavbarViewUiBinder extends UiBinder<Widget, TeamNavbarView> {
	}

	public TeamNavbarView() {
		initWidget(uiBinder.createAndBindUi(this));
		
//		 final Map<Menus , NavLink> map = new EnumMap<Menus, NavLink>(Menus.class);
//	        for (Menus menu : Menus.values()) {
//	            NavLink link = new NavLink(menu.getDisplay());
//	            link.setHref("#" + menu.getName() + ":");
//	            
//	            if(menu == Menus.GWT) {
//	                nav.add(new Divider());
//	            }
//	            nav.add(link);
//	            
//	            map.put(menu, link);
//	        }
	        
	}

	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}
	
	@UiHandler("nlgroups")
	void onNlGruposClick(ClickEvent event) {
		presenter.groupsOption();
	}

	
	@UiHandler("nlplayers")
	void onNlJugadoresClick(ClickEvent event) {
		presenter.groupsPlayers();
	}
	
	
	
}
