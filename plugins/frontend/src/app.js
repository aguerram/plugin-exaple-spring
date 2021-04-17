import React, {Suspense} from 'react';
import loadable from '@loadable/component'
import {ErrorBoundary} from 'react-error-boundary'
import {ErrorFallback} from "./shared/ErrorFallback";


const UserPlugin = loadable(() => import(`./plugins/users/index`))
const DashboardPlugin = loadable(() => import(`./plugins/dashboard/index`))


function App({pluginID}) {

    const renderPlugin = () => {
        switch (pluginID) {
            case "users":
                return <UserPlugin/>
            case "dashboard":
                return <DashboardPlugin/>
        }
    }

    return (
        <ErrorBoundary
            FallbackComponent={ErrorFallback}
        >
            {renderPlugin()}
        </ErrorBoundary>
    );
}

export default App;