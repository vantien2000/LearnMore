import React from "react";

interface SharedInputProps {
  label?: string; // Nhãn hiển thị trên input
  name: string; // tên field
  value?: any;
  type?: "text" | "password" | "email" | "number";
  placeholder?: string;
  error?: string; //Hiển thị validate nếu có
  onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

const SharedInput: React.FC<SharedInputProps> = ({
  label,
  name,
  type,
  value,
  placeholder,
  error,
  onChange,
}) => {
    return (
      <div>
        {label && <label htmlFor={name} className="block mb-1 text-sm font-medium">{label}</label>}

        <input 
          id={name}
          value={value}
          type={type}
          placeholder={placeholder}
          name={name}
          onChange={onChange}
          className={`w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 ${
          error ? "border-red-500 focus:ring-red-500" : "border-gray-300 focus:ring-blue-500"
        }`}
        />

        {error && <p className="text-red-500 text-sm mt-1">{error}</p>}
      </div>
    );
};

export default SharedInput;