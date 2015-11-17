package mum.edu.blog.utils;

import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavigationViewPreparer implements ViewPreparer {	

	@Autowired
	NavigationService navigationService;
	@Override
	public void execute(Request tilesRequest, AttributeContext attributeContext) throws PreparerException {
		List<Navigation> navList = navigationService.navList();
		for (int i = 0; i < navList.size(); i++) {
			attributeContext.putAttribute("navList", new Attribute(navList));
		}
		
	}
}