/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/mobile/vMob92Data",
            method: "get",
            dataType: "json",
            success: function(data){
                initEchart("echart1",data);
            },
            error: function(){

            }
        })
    }
    function initEchart(domId,echartData){
        var legendData = ["No Data","Bad","Good"];
        var xAxisData = ["TREG7","TREG6","TREG5","TREG4","TREG3","TREG2","TREG1"];
        var colorData = ["#707B8E","#ECD201","#5ACF05"];
        var greenData = echartData.green;
        var redData = echartData.red;
        var orangeData = echartData.orange;
        var greenPercent = echartData.greenPercent;
        var redPercent = echartData.redPercent;
        var orangePercent = echartData.orangePercent;
        var myChart = echarts.init(document.getElementById(domId));
        for(var i=0;i<5;i++){
            console.log(redData[i]);
        }
        option = {
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },

            title: {
                text: 'Quality CNOP',
                x:'left',
                textStyle: {
                    fontSize: 26,
                    fontWeight: 'bolder',
                    color: '#FFFFFF'          // 主标题文字颜色
                },
            },
            legend: {
                x:'right',
                data:legendData,
                color:'#FFFFFF',
                textStyle:{    //图例文字的样式
                    color:'#FFFFFF',
                    fontSize: 26,
                }
            },

            xAxis : [
                {
                    type : 'value',
                    axisLine:{show:false},
                    axisLabel : {//轴数据风格
                        show:false,
                        interval:0,    // {number}刻度的长短，可设为数字 间隔
                        //rotate: 30,
                        margin:5,
                        splitNumber: 100,
                        textStyle:{
                            color: '#FFFFFF'
                        }
                    },
                    splitLine : { //网格分隔线
                        show:false,

                        lineStyle: {
                            fontSize: 26,
                            color: '#FFFFFF',
                            type: 'dashed',
                            width: 1
                        }
                    }
                }
            ],
            yAxis : [
                {
                    type : 'category',
                    data : xAxisData,
                    axisLine:{show:false},
                    splitLine : { //网格分隔线
                        show:false,

                        lineStyle: {
                            fontSize: 26,
                            color: 'RGB( 255, 255, 255)',
                            type: 'dashed',
                            width: 1
                        }
                    },
                    axisLabel : {//轴数据风格
                        show:true,
                        interval:0,    // {number}刻度的长短，可设为数字 间隔
                        margin:5,
                        splitNumber: 100,
                        textStyle:{
                            fontSize: 20,
                            color: '#FFFFFF'
                        }
                    }
                }
            ],
            color:colorData,
            grid:{

                borderWidth:0,//外围边框线
                borderColor:'#e3b'
            },
            series : [
                {
                    name:'No Data',
                    type:'bar',
                    stack: 'percentage',
                    itemStyle : {
                        fontSize: 26,
                        normal: {
                            label : {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'normal'
                                },
                                formatter:function(obj){
                                    var c="";
                                    var xaixsData=xAxisData;
                                    var redDatas=redData;
                                    for(var i=0;i<4;i++){
                                        if(obj.name==xaixsData[i]){
                                            c+=redDatas[i];
                                        }
                                    }
                                    return c;
                                },
                                position: 'insideRight'
                            }
                        }
                    },
                    data:redPercent
                },
                {
                    name:'Bad',
                    type:'bar',
                    stack: 'percentage',
                    itemStyle : {
                        fontSize: 26,
                        normal: {
                            label : {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'normal'
                                },
                                formatter:function(obj){
                                    var c="";
                                    var xaixsData=xAxisData;
                                    var orangeDatas=orangeData;
                                    for(var i=0;i<4;i++){
                                        if(obj.name==xaixsData[i]){
                                            c+=orangeDatas[i];
                                        }
                                    }
                                    return c;
                                },
                                position: 'insideRight'
                            }
                        }
                    },
                    data:orangePercent
                },
                {
                    name:'Good',
                    type:'bar',
                    stack: 'percentage',
                    itemStyle : {
                        fontSize: 26,
                        normal: {
                            label : {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'normal'
                                },
                                formatter:function(obj){
                                    var c="";
                                    var xaixsData=xAxisData;
                                    var greenDatas=greenData;
                                    for(var i=0;i<4;i++){
                                        if(obj.name==xaixsData[i]){
                                            c+=greenDatas[i];
                                        }
                                    }
                                    return c;
                                },
                                position: 'insideRight'
                            }
                        }
                    },
                    data:greenPercent
                }
            ]
        };
        myChart.setOption(option);
    }
    initData();
}());