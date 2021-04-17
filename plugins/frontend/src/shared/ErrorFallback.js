import React, {useEffect, useState} from "react";

export function ErrorFallback({error, resetErrorBoundary}) {
    const [componentError, setComponentError] = useState(null)
    useEffect(() => {
        if (error.message) {
            if (String(error.message).includes("Cannot find module")) {
                setComponentError(1)
            } else {
                setComponentError(2)
            }
        }
    }, [])
    if (componentError === 1)
        return <div>
            <h1>Plugin not registered</h1>
        </div>
    return (
        <div role="alert">
            <p>Something went wrong:</p>
        </div>
    )
}