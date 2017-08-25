package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import nl.crashdata.chartjs.data.ChartJsDataPoint;
import nl.crashdata.chartjs.data.ChartJsDataset;

public class SimpleChartJsDataset<K extends Serializable, V extends Serializable>
		implements ChartJsDataset<K, V>
{
	private static final long serialVersionUID = 1L;

	private String label;

	private String backgroundColor;

	private String borderColor;

	private List<ChartJsDataPoint<K, V>> data;

	private Boolean fill;

	@Override
	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	@Override
	public String getBackgroundColor()
	{
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	@Override
	public String getBorderColor()
	{
		return borderColor;
	}

	public void setBorderColor(String borderColor)
	{
		this.borderColor = borderColor;
	}

	@Override
	public List<ChartJsDataPoint<K, V>> getData()
	{
		return data;
	}

	public void setData(List<ChartJsDataPoint<K, V>> data)
	{
		this.data = data;
	}

	public void setData(Map<K, V> data)
	{
		this.data = data.entrySet()
			.stream()
			.map(e -> new SimpleChartJsDataPoint<>(e.getKey(), e.getValue()))
			.collect(Collectors.toList());
	}

	@Override
	public Boolean isFill()
	{
		return fill;
	}

	public void setFill(Boolean fill)
	{
		this.fill = fill;
	}
}