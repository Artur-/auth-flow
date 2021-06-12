package com.example.application.views.private;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;

@Route(value = "private", layout = MainView.class)
@PageTitle("Private")
public class PrivateView extends Div {

    public PrivateView() {
        addClassName("private-view");
        add(new Text("Content placeholder"));
    }

}
