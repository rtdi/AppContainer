package io.rtdi.appcontainer.designtimeobjects.hdbview;

import io.rtdi.appcontainer.objects.view.HanaView;
import io.rtdi.appcontainer.utils.HanaSQLException;

public class HDBView {

	public static HanaView parseHDBViewText(String text, String schemaname, String viewname) throws HanaSQLException {
		HanaView view = new HanaView(schemaname, viewname);
		int skip = 0;
		if (text.startsWith("VIEW ")) {
			skip = 4;
			while (text.length() > skip && text.charAt(skip) == ' ') {
				skip++;
			}
			skip = text.indexOf(' ', skip);
		}
		view.setViewDefinition(text.substring(skip));
		return view;
	}
}
