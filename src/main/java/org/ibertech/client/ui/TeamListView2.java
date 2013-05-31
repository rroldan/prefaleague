package org.ibertech.client.ui;

import java.util.List;

import org.ibertech.shared.Team;

import com.github.gwtbootstrap.client.ui.ButtonCell;
import com.github.gwtbootstrap.client.ui.CellTable;
import com.github.gwtbootstrap.client.ui.Column;

import com.github.gwtbootstrap.client.ui.SimplePager;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class TeamListView2 extends Composite implements ITeamListView {

	private static TeamListView2UiBinder uiBinder = GWT
			.create(TeamListView2UiBinder.class);

	@UiField(provided = true)
	//CellTable<Team> cellTable = new CellTable<Team>(1000, (Resources) GWT.create(TableResources.class));
	CellTable<Team> cellTable = new CellTable<Team>(4, GWT.<CellTable.SelectableResources>create(CellTable.SelectableResources.class));
	SimplePager simplePager = new SimplePager();
	
	private List<Team> list;

	private Presenter presenter;

	
	interface TeamListView2UiBinder extends UiBinder<Widget, TeamListView2> {
	}

	public TeamListView2() {
		initWidget(uiBinder.createAndBindUi(this));
		
		cellTable.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Create first name column.
				TextColumn<Team> teamNameColumn = new TextColumn<Team>() {
					
					public String getValue(Team team) {
						return team.getTeamName();
					}
				};

				// Make the first name column sortable.
				teamNameColumn.setSortable(true);

				TextColumn<Team> coachColumn = new TextColumn<Team>() {
					
					public String getValue(Team team) {
						return team.getCoach();
					}
				};

				// Make the first name column sortable.
				coachColumn.setSortable(true);

				TextColumn<Team> raceColumn = new TextColumn<Team>() {
					
					public String getValue(Team team) {
						return team.getRace();
					}
				};

				// Make the first name column sortable.
				raceColumn.setSortable(true);

				TextColumn<Team> numfebbColumn = new TextColumn<Team>() {
					
					public String getValue(Team team) {
						return team.getNumFebb();
					}
				};

				// Make the first name column sortable.
				numfebbColumn.setSortable(true);

				TextColumn<Team> clubColumn = new TextColumn<Team>() {
					
					public String getValue(Team team) {
						return team.getClub();
					}
				};

				// Make the first name column sortable.
				clubColumn.setSortable(true);

//				 Column<CompoundDataProxy, String> deleteColumn = new Column<MyDataProxy, String>(new ButtonCell()) {
//						                 public String getValue(CompoundDataProxy c) {
//						                     return "Delete";
//						                 }
//						             };
				
				// Add the columns.
				cellTable.addColumn(teamNameColumn, "Nombre Equipo");
				cellTable.addColumn(coachColumn, "Entrenador");
				cellTable.addColumn(raceColumn, "Raza");
				cellTable.addColumn(numfebbColumn, "N. FEBB");
				cellTable.addColumn(clubColumn, "Club");
				

				// Create a data provider.
				ListDataProvider<Team> dataProvider = new ListDataProvider<Team>();

				// Connect the table to the data provider.
				dataProvider.addDataDisplay(cellTable);

				list = dataProvider.getList();

				// Add a ColumnSortEvent.ListHandler to connect sorting to the
				// java.util.List.
				ListHandler<Team> columnSortHandler = new ListHandler<Team>(list);
//				columnSortHandler.setComparator(firstNameColumn, new Comparator<Contact>() {
//					
//					public int compare(Contact o1, Contact o2) {
//						if (o1 == o2) {
//							return 0;
//						}
//
//						// Compare the first name columns.
//						if (o1 != null) {
//							return (o2 != null) ? o1.getFirstName().compareTo(o2.getFirstName()) : 1;
//						}
//						return -1;
//					}
//				});
//				columnSortHandler.setComparator(lastNameColumn, new Comparator<Contact>() {
//					
//					public int compare(Contact o1, Contact o2) {
//						if (o1 == o2) {
//							return 0;
//						}
//
//						// Compare the last name columns.
//						if (o1 != null) {
//							return (o2 != null) ? o1.getLastName().compareTo(o2.getLastName()) : 1;
//						}
//						return -1;
//					}
//				});
				cellTable.addColumnSortHandler(columnSortHandler);

				// Add a selection model to handle user selection.
				final SingleSelectionModel<Team> selectionModel = new SingleSelectionModel<Team>();
				cellTable.setSelectionModel(selectionModel);
				selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					
					public void onSelectionChange(SelectionChangeEvent event) {
						Team selectedTeam = selectionModel.getSelectedObject();
						System.out.println("TeamListView2 .onSelectionChange()");
						presenter.select(selectedTeam);
					}
				});
	}

	
	public void setWidget(IsWidget w) {
		// TODO Auto-generated method stub
		
	}

	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}

	
	public void selectInitialRow(int i) {
		// TODO Auto-generated method stub
		
	}

	
	public void initialize(List<Team> teams) {
		list.clear();
		for (Team team : teams) {
			list.add(team);
		}
		// sort first names
		cellTable.getColumnSortList().push(cellTable.getColumn(0));

		
	}
	
	
	public void selectInitialTeam(Team team) {
		cellTable.getSelectionModel().setSelected(team, true);
		
	}

}
