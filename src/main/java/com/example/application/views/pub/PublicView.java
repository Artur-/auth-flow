package com.example.application.views.pub;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "public", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Public")
@AnonymousAllowed
public class PublicView extends Div {

    public PublicView() {
        addClassName("public-view");
        add(new Text("Content placeholder"));
    }

}
