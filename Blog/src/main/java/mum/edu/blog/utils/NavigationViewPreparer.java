package mum.edu.blog.utils;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.stereotype.Service;

@Service
public class NavigationViewPreparer implements ViewPreparer {	

	@Override
	public void execute(Request tilesRequest, AttributeContext attributeContext) throws PreparerException {
		attributeContext.putAttribute("test", new Attribute("test menskfhsak"));
	}
}