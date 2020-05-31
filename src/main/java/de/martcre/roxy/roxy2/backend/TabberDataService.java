package de.martcre.roxy.roxy2.backend;

import com.vaadin.flow.data.provider.CallbackDataProvider;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.FilterItem;
import org.apache.metamodel.schema.Column;

import java.util.List;
import java.util.Set;

public interface TabberDataService extends CallbackDataProvider.FetchCallback<Row, Set<FilterItem>>,CallbackDataProvider.CountCallback<Row, Set<FilterItem>> {
    public List<Column> getColumns();
}
