import React from 'react';
import loadable from '@loadable/component'


const DashboardIndex = loadable(() => import('./plugins/dashboard'))
const UsersIndex = loadable(() => import('./plugins/user-management'))

function App({pluginID}) {

    const pluginRender = () => {
        switch (pluginID) {
            case "dashboard":
                return <DashboardIndex/>
            case "users":
                return <UsersIndex/>;
        }
    }

    return (
        <div>
            <h1>This is frontend for plugin {pluginID}</h1>
            <hr/>
            {pluginRender()}
        </div>
    );
}

export default App;