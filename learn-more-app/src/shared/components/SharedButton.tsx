import React from "react";

interface SharedButtonProps {
  value?: string;
  type?: "submit" | "button";
}

const SharedButton: React.FC<SharedButtonProps> = ({
  type,
  value
}) => {
  return (
    <button
      type={type}
      className="w-full bg-blue-500 text-white py-2 rounded-md hover:bg-blue-600 transition"
    >
      {value}
    </button>
  );
};

export default SharedButton;