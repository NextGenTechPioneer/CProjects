 Project: ResumeScannerUI (React)
// File: src/App.js

import React, { useState } from "react";
import axios from "axios";

function App() {
  const [resumeText, setResumeText] = useState("");
  const [file, setFile] = useState(null);
  const [result, setResult] = useState("");
  const [loading, setLoading] = useState(false);

  const analyzeText = async () => {
    setLoading(true);
    try {
      const response = await axios.post("http://localhost:5000/api/resume/analyze", {
        resumeText
      });
      setResult(response.data);
    } catch (error) {
      console.error("Error analyzing resume text", error);
      setResult("Failed to analyze resume text.");
    } finally {
      setLoading(false);
    }
  };

  const uploadFile = async () => {
    if (!file) {
      alert("Please select a file first.");
      return;
    }
    setLoading(true);
    try {
      const formData = new FormData();
      formData.append("resumeFile", file);

      const response = await axios.post("http://localhost:5000/api/resume/upload", formData, {
        headers: {
          "Content-Type": "multipart/form-data"
        }
      });
      setResult(response.data);
    } catch (error) {
      console.error("Error uploading resume file", error);
      setResult("Failed to analyze uploaded resume.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen p-6 bg-gray-100">
      <div className="max-w-4xl mx-auto bg-white p-8 rounded-xl shadow-md">
        <h2 className="text-2xl font-bold mb-6">AI-Powered Resume Scanner</h2>

        <textarea
          className="w-full border rounded p-2 mb-4"
          rows="6"
          value={resumeText}
          onChange={(e) => setResumeText(e.target.value)}
          placeholder="Paste your resume text here..."
        ></textarea>

        <div className="flex gap-4 mb-4">
          <button
            className="bg-blue-500 hover:bg-blue-600 text-white px-4 py-2 rounded"
            onClick={analyzeText}
          >
            Analyze Text
          </button>
        </div>

        <div className="flex flex-col gap-2 mb-4">
          <input type="file" onChange={(e) => setFile(e.target.files[0])} />
          <button
            className="bg-green-500 hover:bg-green-600 text-white px-4 py-2 rounded"
            onClick={uploadFile}
          >
            Upload and Analyze File
          </button>
        </div>

        {loading ? (
          <p className="text-gray-700">Analyzing...</p>
        ) : (
          <pre className="bg-gray-200 p-4 rounded whitespace-pre-wrap">{result}</pre>
        )}
      </div>
    </div>
  );
}

export default App;
