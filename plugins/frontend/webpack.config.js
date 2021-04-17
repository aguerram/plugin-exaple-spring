const path = require('path');
const webpack = require('webpack');

const outPutDir = path.resolve(__dirname, '../src/main/resources/static')

module.exports = {
    entry: path.resolve(__dirname, './src/main.js'),
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: ['babel-loader'],
            },
        ],
    },
    resolve: {
        extensions: ['*', '.js', '.jsx'],
    },
    output: {
        // path: path.resolve(__dirname, './dist'),
        path: outPutDir,
        filename: 'bundle.js',
    },
    plugins: [new webpack.HotModuleReplacementPlugin()],
    devServer: {
        contentBase: outPutDir,
        hot: true
    },
};