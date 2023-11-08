import React, {useState} from "react";

const Display=(props) => {
    const {allTabs, currentTabIndex} = props;
return(
    <div className="results">
        <h5>{allTabs[currentTabIndex].content}</h5>
    </div>
)
}

export default Display;