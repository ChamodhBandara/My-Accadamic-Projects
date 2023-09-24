import React from 'react';
// ProfileCard.jsx
import './Card.css';
import img1 from './images/Profile.jpg.jpg'



function Card() {
  return (
    <div className="profile-card">
      <img src={img1}   />
      <h2 className="profile-name">Chamodh Abeykoon</h2>
      <p className="profile-description">Trainee Softwere Engineer</p>
      <p className="profile-bio">Expertice Sevaral Frameworks</p>
    </div>
  );
}

export default Card;

 // Add this line to make it a module
