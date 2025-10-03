import React, { useState } from "react";
import { useAppDispatch } from "../../../app/hook";
import { loginAsync } from "../LoginSlice";
import SharedInput from "../../../shared/components/SharedInput";
import SharedButton from "../../../shared/components/SharedButton";

type LoginFormInputs = {
  email: string,
  password: string
}
const LoginForm: React.FC = () => {
  const [data, setData] = useState({ email: "", password: "" });
  const dispatch = useAppDispatch();


  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    let result = await dispatch(loginAsync(data));
    // Gọi API login hoặc dispatch Redux ở đây
  };

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setData((prev) => ({
      ...prev,
      [name]: value,   // update field tương ứng
    }));
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <form onSubmit={handleSubmit} className="bg-white p-6 rounded-x1 shadow-md w-80">
        <h2 className="text-2xl font-bold text-center mb-4">Login</h2>

        {/* Email */}
        <div className="mb-4">
          <SharedInput 
            label="Email"
            name="email"
            type="email"
            placeholder="Nhập Email"
            onChange={handleChange}
          />
        </div>

        {/* Password*/}
        <div className="mb-4">
          <SharedInput 
            label="Password"
            name="password"
            type="password"
            placeholder="Nhập Password"
            onChange={handleChange}
            />
        </div>

        <SharedButton 
          type="submit"
          value="Login"
        />
      </form>
    </div>
  );
};

export default LoginForm;