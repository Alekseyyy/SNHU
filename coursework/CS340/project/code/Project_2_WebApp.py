
######################################################
# The Animal Tracker Database (Web Application Fro-  #
#   -ntend; CS-340 (Project 2)                       #
######################################################

#
# Starter code by "CS-340" course designers
# Refinements by Alexander Ahmann <alexander.ahmann@snhu.edu>
#

# Setup the Jupyter version of Dash
from jupyter_dash import JupyterDash

# Configure the necessary Python module imports for dashboard components
import dash_leaflet as dl
from dash import dcc, html
import plotly.express as px
from dash import dash_table
from dash.dependencies import Input, Output, State
import base64
import plotly.figure_factory as ff
JupyterDash.infer_jupyter_proxy_config()

# Configure OS routines
import os

# Configure the plotting routines
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

#### Import Python CRUD Module ####
from CRUD_Python_Module import *

###########################
# Data Manipulation / Model
###########################

# Configuration
username = "aacuser"
password = "WingsofRedemption"
hostname = "localhost"

# Connection / DB cursor
db = AnimalShelter(
    username,
    password,
    hostname
) # Note that I have made a slight modification
# to the AnimalShelter class, I only am supplying
# a needed ``username``, ``password`` and ``host
# name`` when creating a new instance. The other
# parameters seem standard, ergo redundant to
# request. 

# These are queries that I have worked out for selecting documents
#   documenting breeds that are the optimal candidate for specific
#   kinds of rescue missions.
specific_queries = {
    "water": {
      "breed": {
      "$in": ['Labrador Retriever Mix',
      'Chesapeake Bay Retriever',
      'Newfoundland']
    },
    "sex_upon_outcome": 'Intact Female',
    "age_upon_outcome_in_weeks": {
        "$gte": 26, "$lte": 156
      }
    },
    "mt_or_wild": {
      "breed": {
      "$in": ['German Shepherd',
        'Alaskan Malamute',
        'Old English Sheepdog',
        'Siberian Husky',
        'Rottweiler']
    },
    "sex_upon_outcome": 'Intact Male',
    "age_upon_outcome_in_weeks": {
        "$gte": 26, "$lte": 156
      }
    },
    "dis_or_indv": {
        "breed": {
          "$in": ['Doberman Pinscher',
          'German Shepherd',
          'Golden Retriever',
          'Bloodhound',
          'Rottweiler']
    },
    "sex_upon_outcome": 'Intact Male',
    "age_upon_outcome_in_weeks": {
        "$gte": 20, "$lte": 300
      }
    },
    "no_filter": {}
}

# class read method must support return of list object and accept projection json input
# sending the read method an empty document requests all documents be returned
df = pd.DataFrame.from_records(db.read(specific_queries["no_filter"]))

# MongoDB v5+ is going to return the '_id' column and that is going to have an 
# invlaid object type of 'ObjectID' - which will cause the data_table to crash - so we remove
# it in the dataframe here. The df.drop command allows us to drop the column. If we do not set
# inplace=True - it will reeturn a new dataframe that does not contain the dropped column(s)
df.drop(columns=['_id'],inplace=True)

## Debug
# print(len(df.to_dict(orient='records')))
# print(df.columns)

###########################
# Dashboard Layout / View #
###########################
app = JupyterDash(__name__)

# FIX ME Add in Grazioso Salvare’s logo
image_filename = 'Grazioso Salvare Logo.png' # replace with your own image
encoded_image = base64.b64encode(open(image_filename, 'rb').read())

# Place the HTML image tag in the line below into the app.layout code according to your design
# Also remember to include a unique identifier such as your name or date
#html.Img(src='data:image/png;base64,{}'.format(encoded_image.decode()))

app.layout = html.Div([
#    html.Div(id='hidden-div', style={'display':'none'}),
    html.Center([
            html.A(
                html.Img(
                    src='data:image/png;base64,{}'.format(
                    encoded_image.decode()),
                    style={'width': '50%', 'max-width': '150px'} 
                ),
                href="https://snhu.edu",
                target="_blank"
            ),
            html.B(
                html.H1('The Animal Tracker Database')
            ),
            html.H3("By Alexander Ahmann <alexander.ahmann@snhu.edu>")
    ]),
    html.Hr(),
    html.H3("Filter by Rescue Mission:"),
    html.Div(
        
#FIXME Add in code for the interactive filtering options. For example, Radio buttons, drop down, checkboxes, etc.
        dcc.RadioItems(id = 'filter-type',
            options = [ 
                { "label": "Water", "value": "water" }, 
                { "label": "Mountain or Wilderness", "value": "mt_or_wild" }, 
                { "label": "Disaster or Individual Tracking", "value":"dis_or_indv" }, 
                { "label": "No filter", "value": "no_filter" }
            ], # Thank you to Joseph Dengler for
                # showing us how to properly use the 
                # "options" argument.
            value = "no_filter"
        )
    ),
    html.Hr(),
    dash_table.DataTable(id='datatable-id',
                        columns=[{"name": i, "id": i, "deletable": False, "selectable": True} for i in df.columns],
                        data=df.to_dict('records'),
                         
                        # Custom parameters to make the web application
                        # work properly and look decent when rendering.
                        row_selectable = "single",
                        selected_rows = [0],
                        page_size = 5,
                        sort_action = "native"
                    ),
    html.Br(),
    html.Hr(),
    #This sets up the dashboard so that your chart and your geolocation chart are side-by-side
    html.Div(className='row',
        style={'display' : 'flex'},
             children=[
        html.Div(
            id='graph-id',
            className='col s12 m6',
            ),
        html.Div(
            id='map-id',
            className='col s12 m6',
            )
        ])
])

#############################################
# Interaction Between Components / Controller
#############################################
    
@app.callback(Output('datatable-id','data'),
              [Input('filter-type', 'value')])
def update_dashboard(filter_type):
    ## FIX ME Add code to filter interactive data table with MongoDB queries
    
    ### CREDIT: CODE SOLUTION AFTER [1]
    data = pd.DataFrame.from_records(
        db.read(specific_queries[filter_type])
    )
    data.drop(columns=['_id'], inplace=True)
    
    return data.to_dict("records")
    ### END CREDITS
    
    #columns=[{"name": i, "id": i, "deletable": False, "selectable": True} for i in df.columns]
    #data=df.to_dict('records')
    #return (data,columns)
    

# Display the breeds of animal based on quantity represented in
# the data table
@app.callback(
    Output('graph-id', "children"),
    [Input('datatable-id', "derived_virtual_data")]
)
def update_graphs(viewData):
    ### WORKED SOLUTION ####
    # add code for chart of your choice (e.g. pie chart) #

    dff = pd.DataFrame.from_dict(viewData)
    male_condition = dff[dff["sex_upon_outcome"] == "Intact Male"]
    male_distribution = male_condition["age_upon_outcome_in_weeks"]
    female_condition = dff[dff["sex_upon_outcome"] == "Intact Female"]
    female_distribution = female_condition["age_upon_outcome_in_weeks"]
    
    render = ff.create_distplot(
        [male_distribution, female_distribution],
        ["Age (Intact Males)", "Age (Intact Females)"],
    ) # a KDE plot because pie charts are rubbish ;-)
    render.update_layout(title_text="Age Distribution of Intact Males \nvs Intact Females by the Current Filter")

    return [
        #html.H2("KDE Plot of Age Distribution of Animals for the Selected Filter"),
        dcc.Graph(figure = render)
    ]
    
    #return [
    #    dcc.Graph(            
    #        figure = px.pie(df, names='breed', title='Preferred Animals')
    #    )
    #]
    
#This callback will highlight a cell on the data table when the user selects it
@app.callback(
    Output('datatable-id', 'style_data_conditional'),
    [Input('datatable-id', 'selected_columns')]
)
def update_styles(selected_columns):
    return [{
        'if': { 'column_id': i },
        'background_color': '#D2F3FF'
    } for i in selected_columns]

# This callback will update the geo-location chart for the selected data entry
# derived_virtual_data will be the set of data available from the datatable in the form of 
# a dictionary.
# derived_virtual_selected_rows will be the selected row(s) in the table in the form of
# a list. For this application, we are only permitting single row selection so there is only
# one value in the list.
# The iloc method allows for a row, column notation to pull data from the datatable
@app.callback(
    Output('map-id', "children"),
    [Input('datatable-id', "derived_virtual_data"),
     Input('datatable-id', "derived_virtual_selected_rows")])
def update_map(viewData, index):  
    if viewData is None:
        return
    elif index is None:
        return
    
    dff = pd.DataFrame.from_dict(viewData)
    # Because we only allow single row selection, the list can be converted to a row index here
    if index is None:
        row = 0
    else: 
        row = index[0]
        
    # Austin TX is at [30.75,-97.48]
    return [
        dl.Map(style={'width': '1000px', 'height': '500px'}, center=[30.75,-97.48], zoom=10, children=[
            dl.TileLayer(id="base-layer-id"),
            dl.Marker(position=[dff.iloc[row,13],dff.iloc[row,14]], children=[
                dl.Tooltip(dff.iloc[row,4]),
                dl.Popup([
                    #html.H2(),
                    html.B("Animal ID: {0}".format(dff.iloc[row,2])),
                    html.Br(),
                    html.B("Name: {0}".format(dff.iloc[row,9])),
                    html.Br(),
                    html.B("Breed: {0}".format(dff.iloc[row,4])),
                    html.Br(),
                    html.B("DOB: {0}".format(dff.iloc[row,6]))
                ])
            ])
        ])
    ]

# Run app and display result in jupyterlab mode, note, if you have previously run a prior app, the default port of 8050 may not be available, if so, try setting an alternate port.
app.run_server() 

#############
# References
#############

#
# 1. "JPDengler" (n.d.). CS-340 Client/Server Project 2. Retrieved on Oct. 20, 2025 from:
#   https://github.com/JPDengler/Client-Server-Development-CS-340/blob/main/ProjectTwoDashboard.ipynb
#

