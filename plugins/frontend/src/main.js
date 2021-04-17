import React from 'react';
import ReactDOM from 'react-dom';
import App from "./app";

const props = window.props
const pluginID = props?.pluginID
ReactDOM.render(
    <App
        pluginID={pluginID}
    />,
    document.getElementById('app')
);

module.hot.accept();