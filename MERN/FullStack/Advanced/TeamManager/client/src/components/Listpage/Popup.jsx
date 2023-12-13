import React from 'react';

const Popup = ({ selectedPlayerName, onConfirm, onClose }) => {
    return (
        <div className="popup-overlay">
            <div className="popup">
                <p>Are you sure you want to delete {selectedPlayerName}?</p>
                <button onClick={onConfirm}>Yes</button>
                <button onClick={onClose}>No</button>
            </div>
        </div>
    );
};

export default Popup;
