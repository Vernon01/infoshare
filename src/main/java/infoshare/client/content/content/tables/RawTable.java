package infoshare.client.content.content.tables;

import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;
import infoshare.RestApi.RestApiConnectorClass;
import infoshare.RestApi.UrlPath;
import infoshare.client.content.MainLayout;
import infoshare.domain.Category;
import infoshare.domain.Content;
import infoshare.domain.ContentType;
import infoshare.services.Content.ContentService;
import infoshare.services.Content.Impl.ContentServiceImp;
<<<<<<< HEAD
import infoshare.services.ContentType.ContentTypeService;
import infoshare.services.ContentType.Impl.ContentTypeServiceImpl;
=======
>>>>>>> origin/master
import infoshare.services.category.CategoryService;
import infoshare.services.category.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hashcode on 2015/06/24.
 */
public class RawTable extends Table {

    @Autowired
    private ContentService contentService = new ContentServiceImp();

    private CategoryService categoryService = new CategoryServiceImpl();



    private final MainLayout main;

    public RawTable(MainLayout mainApp){
        this.main = mainApp;
        setSizeFull();
        addStyleName(ValoTheme.TABLE_BORDERLESS);
        addStyleName(ValoTheme.TABLE_NO_STRIPES);
        addStyleName(ValoTheme.TABLE_NO_VERTICAL_LINES);
        addStyleName(ValoTheme.TABLE_SMALL);
        addContainerProperty("Title",String.class,null);
        addContainerProperty("Category",String.class,null);
        addContainerProperty("Creator",String.class,null);
    //    addContainerProperty("Source",String.class,null);
        addContainerProperty("Date Created",String.class,null);

        try {
            contentService.findAll().stream().filter(content -> content != null).forEach(this::loadTable);
        }catch (Exception e){
        }
         setNullSelectionAllowed(false);
         setSelectable(true);
         setImmediate(true);
    }

    public void loadTable(Content content) {
        System.out.println(content.getCategory().toString() +"thulebona");
        DateFormat formatter = new SimpleDateFormat("dd - MMMMMMM - yyyy");
        UrlPath.isEdited = RestApiConnectorClass.
                readAll(UrlPath.ContentLinks.isEditedAndPlublished + content.getId(), String.class);
        for (int i = 0; i < UrlPath.isEdited.size(); i++) {
            if (UrlPath.isEdited.get(i).equalsIgnoreCase("false")) {
                addItem(new Object[]{
                        content.getTitle(),
                        content.getCategory(),
                        content.getCreator(),
                        //    content.getSource(),
                        formatter.format(content.getDateCreated())
                }, content.getId());
            }
        }
    }

}
