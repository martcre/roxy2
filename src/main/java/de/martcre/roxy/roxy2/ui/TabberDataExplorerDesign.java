package de.martcre.roxy.roxy2.ui;


import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.apache.metamodel.data.Row;

@SuppressWarnings("serial")
public class TabberDataExplorerDesign extends VerticalLayout {
	
	private Grid<Row> grid;
	private Checkbox liveFilteringMode;
	private Checkbox enableAutomaticWildcards;
	
	public TabberDataExplorerDesign() {
		setSizeFull();
		add(getLiveFilteringMode(), getEnableAutomaticWildcards(), getGrid());
	}

	/**
	 * The main grid
	 * 
	 * @return the main grid
	 */
	public Grid<Row> getGrid() {
		if (grid == null) {
			grid = new Grid<>(Row.class);
			grid.setSizeFull();
		}
		return grid;
	}
	
	/**
	 * The setting for the Live Filtering Mode.
	 *
	 * @return the checkbox
	 */
	public Checkbox getLiveFilteringMode() {
		if (liveFilteringMode == null) {
			liveFilteringMode = new Checkbox();
			liveFilteringMode.setId("liveFilteringMode");
			liveFilteringMode.setLabel("Enable Live Filtering Mode");
		}

		return liveFilteringMode;
	}
	
	/**
	 * The setting for enabling Wildcards.
	 * 
	 * @return the checkbox
	 */
	public Checkbox getEnableAutomaticWildcards() {
		if (enableAutomaticWildcards == null) {
			enableAutomaticWildcards = new Checkbox();
			enableAutomaticWildcards.setId("enableAutomaticWildcards");
			enableAutomaticWildcards.setLabel("Automatically add Wildcards");
		}
		return enableAutomaticWildcards;
	}

}
