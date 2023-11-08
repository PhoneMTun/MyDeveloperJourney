import React, {useState} from "react";


const Tab= props => {
    const {allTabs, currentTabIndex, setCurrentTabIndex}=props;

    const tabStyle = (index)=>{
        if (index===currentTabIndex){
            return "selectedTab";
        }else {
            return "nonSelectedTab";
        }
}

    const setSelectedTabIndex = (index)=>{
        setCurrentTabIndex(index);
    }


    return(
        <div style={{ margin: "auto", width: "100%", textAlign: "left"}}>
        
            {
                allTabs.map((item, index)=>(
                    <div className={`tab ${tabStyle(index)}` } key={index} onClick={(e)=> setSelectedTabIndex(index)}>
                        {item.label}
                    </div>
                ))
            }
        </div>   
            
    )
}
    
export default Tab





