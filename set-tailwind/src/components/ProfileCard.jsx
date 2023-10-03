// src/components/VerticalProfileCard.jsx
import React from 'react';
import image1 from '@/images/Profile.jpg';

const ProfileCard = () => {
  return (
    <div className=" h-screen flex justify-center items-center  bg-pink-400">
      <div className="bg-white w-80 h-96 p-6 shadow-lg rounded-lg flex flex-col justify-center items-center">
        <img
          src={image1}
          alt="Profile"
          className="w-39.5 h-40 rounded-full mb-4"
        />
        <div className="text-center">
          <h2 className="text-xl font-semibold">Chamodh Abeykoon</h2>
          <p className="text-gray-500">Trainee Software Engineer</p>
          <p className="mt-2 text-gray-700">
            Expertice about sevaral Frameworks. (Backend,Frontend)
          </p>
        </div>
      </div>
    </div>
  );
};

export default ProfileCard;



