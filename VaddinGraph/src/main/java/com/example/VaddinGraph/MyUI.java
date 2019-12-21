package com.example.VaddinGraph;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.config.PieChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.data.PieDataset;
import com.byteowls.vaadin.chartjs.options.InteractionMode;
import com.byteowls.vaadin.chartjs.options.Position;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.CategoryScale;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.byteowls.vaadin.chartjs.utils.ColorUtils;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		HorizontalLayout hl = new HorizontalLayout();
		Button lineButton = new Button();
		Button pieButton = new Button();
		Button remove = new Button();
		Component nComponent = getChart();
		Component pComponent = getPieChart();
		lineButton.setCaption("Line Chart");
		hl.setMargin(true);
		pieButton.setCaption("Pie Chart");
		remove.setCaption("Clear");
		lineButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				hl.addComponent(nComponent);
			}
		});
		pieButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hl.addComponent(pComponent);
			}
		});
		remove.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				hl.removeComponent(nComponent);
				hl.removeComponent(pComponent);
			}
		});
		
		hl.addComponent(lineButton);
		hl.addComponent(pieButton);
		hl.addComponent(remove);;
		setContent(hl);
	}

	String height = "300";
	String width = "500";

	public Component getChart() {
		LineChartConfig lineConfig = new LineChartConfig();
		lineConfig.data().labels("January", "February", "March", "April", "May", "June", "July")
				.addDataset(new LineDataset().label("My First dataset").fill(false))
				.addDataset(new LineDataset().label("My Second dataset").fill(false))
				.addDataset(new LineDataset().label("Hidden dataset").hidden(true)).and().options().responsive(true)
				.title().display(true).text("Chart.js Line Chart").and().tooltips().mode(InteractionMode.INDEX)
				.intersect(false).and().hover().mode(InteractionMode.NEAREST).intersect(true).and().scales()
				.add(Axis.X,
						new CategoryScale().display(true).scaleLabel().display(true).labelString("Month").and()
								.position(Position.TOP))
				.add(Axis.Y, new LinearScale().display(true).scaleLabel().display(true).labelString("Value").and()
						.ticks().suggestedMin(-10).suggestedMax(250).and().position(Position.RIGHT))
				.and().done();

		// add random data for demo
		List<String> labels = lineConfig.data().getLabels();
		for (Dataset<?, ?> ds : lineConfig.data().getDatasets()) {
			LineDataset lds = (LineDataset) ds;
			List<Double> data = new ArrayList<>();
			for (int i = 0; i < labels.size(); i++) {
				data.add((double) Math.round(Math.random() * 100));
			}
			lds.dataAsList(data);
			lds.borderColor(ColorUtils.randomColor(0.3));
			lds.backgroundColor(ColorUtils.randomColor(0.5));
		}

		ChartJs chart = new ChartJs(lineConfig);
		chart.setJsLoggingEnabled(true);
		chart.setHeight(height);
		chart.setWidth(width);

		return chart;
	}

	public Component getPieChart() {
		PieChartConfig piechart = new PieChartConfig();
		piechart.data().labels("Yield", "Cost", "Rate").addDataset(new PieDataset().label("DATASET")).and();
		piechart.options().responsive(true).title().display(true).text("Simple piechart").and().animation()
				.animateRotate(true).and().done();
		List<String> pieLabel = piechart.data().getLabels();
		for (Dataset<?, ?> ds : piechart.data().getDatasets()) {
			PieDataset pds = (PieDataset) ds;
			List<Double> data = new ArrayList();
			List<String> colors = new ArrayList<>();
			for (int i = 0; i < pieLabel.size(); i++) {
				data.add((double) Math.round(Math.random() * 100));
				colors.add(ColorUtils.randomColor(0.7));
			}
			pds.backgroundColor(colors.toArray(new String[colors.size()]));
			pds.dataAsList(data);
		}
		ChartJs pieChart = new ChartJs(piechart);
		pieChart.setJsLoggingEnabled(true);
		pieChart.setHeight(height);
		pieChart.setWidth(width);
		return pieChart;
	}

}
