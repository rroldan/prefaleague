package org.ibertech.client.mvp;


import org.ibertech.client.place.TeamEditPlace;
import org.ibertech.client.place.TeamPlace;
import org.ibertech.client.place.PlayerPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers({ TeamPlace.Tokenizer.class, TeamEditPlace.Tokenizer.class, PlayerPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {


}
